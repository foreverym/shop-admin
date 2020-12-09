package com.wy.shop.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileUtil
{
    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);
    private static final String SYMBOL_LEFT = "[";
    private static final String SYMBOL_RIGHT = "]";
    private static final String TO = "] to [";
    private static final String TO_FOLDER = "] to folder [";
    private static Lock lock = new ReentrantLock();


    public static void createDir(File file) throws IOException
    {

        log.info(">>> Start to create director [{}].", file.getAbsolutePath());
        if (file.exists())
        {
            log.info("Thread " + Thread.currentThread().getId() + ": file already exist ");
        }
        else
        {
            // 创建目录原子化
            lock.lock();
            try
            {
                if (file.exists())
                {
                    log.info("Thread " + Thread.currentThread().getId() + " in lock : file already exist ");
                }
                else
                {
                    if (!file.mkdirs())
                    {
                        if (file.exists())
                        {
                            log.info("Thread " + Thread.currentThread().getId() + ": mkdir failed, file already exist ");
                        }
                        else
                        {
                            log.error("Thread " + Thread.currentThread().getId() + ": mkdir failed, unknown reason ");
                            throw new IOException("Create director failed.");
                        }
                    }
                    else
                    {
                        log.info("Thread " + Thread.currentThread().getId() + ": mkdir successfully");
                    }
                }
            }
            finally
            {
                lock.unlock();
            }
            log.info(">>> End to create director [{}].", file.getAbsolutePath());
        }
    }


    public static void deleteAllFile(File file)
    {
        if (file.exists() && file.isFile() && !file.delete())
        {
            throw new RuntimeException("failed delete file " + file.getPath());
        }
        else if (file.exists() && file.isDirectory())
        {
            File[] fx = file.listFiles();

            for (File aFx : fx)
            {
                deleteAllFile(aFx);
            }

            if (!file.delete())
            {
                throw new RuntimeException(file.getAbsolutePath() + " delete failed");
            }
        }

        if (file.exists() && file.isFile() && !file.delete())
        {
            throw new RuntimeException(file.getAbsolutePath() + " delete failed");
        }
    }


    public static void writeByteToDisk(byte[] data, String targetFile) throws IOException
    {
        log.info(">> Start to generate file [{}].", targetFile);
        File directory = new File(targetFile).getParentFile();
        if (!directory.exists())
        {
            createDir(directory);
        }
        FileOutputStream out = null;

        try
        {
            out = new FileOutputStream(targetFile);
            out.write(data);
            out.flush();
        }
        finally
        {
            if (out != null)
            {
                out.close();
                out = null;
            }
        }

        log.info(">> End to generate file [{}].", targetFile);
    }


    public static byte[] readByteFromDisk(String targetFile) throws IOException
    {
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        byte[] rlt = null;

        byte[] buf = new byte[1024];
        int readByte;
        try
        {
            if (targetFile != null)
            {
                in = new FileInputStream(targetFile);

                out = new ByteArrayOutputStream();

                while ((readByte = in.read(buf)) != -1)
                {
                    out.write(buf, 0, readByte);
                }

                rlt = out.toByteArray();
            }
        }
        finally
        {
            buf = null;

            if (in != null)
            {
                in.close();
                in = null;
            }
            if (out != null)
            {
                out.close();
                out = null;
            }
        }

        return rlt;
    }








}
