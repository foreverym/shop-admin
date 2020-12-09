package com.wy.shop.common.constants;

public final class ExceptionConstants
{

    private ExceptionConstants()
    {
    }

    public static final String SYSTEM_EXCEPTION = "999999";
    // 异常分类
    // Dao层
    public static final String DAO_INSERT_RESULT_0 = "100001";
    public static final String DAO_UPDATE_RESULT_0 = "100002";
    public static final String DAO_DELETE_RESULT_0 = "100003";
    public static final String DAO_SELECTONE_IS_NULL = "100004";
    public static final String DAO_LIST_IS_NULL = "100005";

    // Biz层 共用返回码
    public static final String BIZ_NOT_EXIST = "200001";
    public static final String BIZ_HAS_EXIST = "200002";
    public static final String BIZ_CREATE_FAIL = "200003";
    public static final String BIZ_MODIFY_FAIL = "200004";
    public static final String BIZ_DELETE_FAIL = "200005";

    // Biz层 业务校验返回码
    /**
     * Biz type 不属于B2B
     */
    public static final String BIZ_TYPE_NOT_BELONG_B2B = "210001";

    // Facade层
    public static final String FACADE_JSON_CONVERT_ERROR = "300001";
    public static final String FACADE_JSON_IS_NULL = "300002";
    public static final String FACADE_INVALID_METHOD = "300004";

    // validator层
    public static final String VALIDATOR_PARAM_IS_NULL = "400001";
    public static final String VALIDATOR_PARAM_IS_INVALID = "400002";

    // file validator
    public static final String FILE_CREATION_ERROR = "002001";
    public static final String FILE_CREATION_ERROR_DESC = " File {%s} create error.";
    public static final String VALIDATE_INV_FILE_INVALID = "002002";
    public static final String VALIDATE_INV_FILE_INVALID_DESC = "File {%s} validate error.";
    public static final String FILE_FORMAT_NOT_SUPPORT = "002003";
    public static final String FILE_FORMAT_NOT_SUPPORT_DESC = " File type {%s} is not supported.";
    public static final String FILE_READ_ERROR = "002004";
    public static final String FILE_READ_ERROR_DESC = " File {%s} read error.";
    public static final String ZIP_FILE_ERROR = "002005";
    public static final String ZIP_FILE_ERROR_DESC = "ZIP file{%s} failed.";
    public static final String UPLOAD_FILE_ERROR = "002006";
    public static final String UPLOAD_FILE_ERROR_DESC = "Upload file{%s} failed.";
    public static final String MOVE_FILE_ERROR = "002007";
    public static final String MOVE_FILE_ERROR_DESC = "Move file{%s} failed.";
    public static final String GENERATE_FILE_ERROR = "002008";
    public static final String GENERATE_FILE_ERROR_DESC = "Generate file{%s} failed.";
    public static final String COPY_FILE_ERROR = "002009";
    public static final String COPY_FILE_ERROR_DESC = "Copy file{%s} to folder{%s} failed.";
    public static final String FILE_NOT_EXIST_ERROR = "002010";
    public static final String FILE_NOT_EXIST_ERROR_DESC = "File{%s} does not exist.";
    public static final String GEN_FILE_BYTE_ERROR = "002011";
    public static final String GEN_FILE_BYTE_ERROR_DESC = "Generate file byte failed";

    // 业务校验
    public static final String VALIDATE_COMM_STATUS_NOT_MATCH = "003000";
    public static final String VALIDATE_RTV_STATUS_NOT_MATCH = "003001";
    public static final String VALIDATE_RTV_STATUS_NOT_MATCH_DESC = "Current status (%s) of RTV is not valid for activity %s.";
    public static final String VALIDATE_GI_STATUS_NOT_MATCH = "003002";
    public static final String VALIDATE_GI_STATUS_NOT_MATCH_DESC = "Current status (%s) of GI is not valid for activity %s.";
    public static final String VALIDATE_DN_STATUS_NOT_MATCH = "003003";
    public static final String VALIDATE_DN_STATUS_NOT_MATCH_DESC = "Current status (%s) of DN is not valid for activity %s.";
    public static final String VALIDATE_INV_STATUS_NOT_MATCH = "003004";
    public static final String VALIDATE_INV_STATUS_NOT_MATCH_DESC = "Current status (%s) of INV is not valid for activity %s.";
    public static final String VALIDATE_PO_STATUS_NOT_MATCH = "003005";
    public static final String VALIDATE_PO_STATUS_NOT_MATCH_DESC = "Now the PO status is \"%s\", not \"%s\".";
    public static final String VALIDATE_INV_EXPORT_NOT_MATCH = "003006";
    public static final String VALIDATE_INV_EXPORT_NOT_MATCH_DESC = "The INV [%s] is already exported.";
    public static final String VALIDATE_INV_MATCHING_NOT_MATCH = "003007";
    public static final String VALIDATE_INV_MATCHING_NOT_MATCH_DESC = "The INV matching status is \"MATCHED\" or buyer approval status is \"ACCEPTED\"."
            + "Current matching status is (%s), buyer approval status is (%s).";
    public static final String VALIDATE_GRN_STATUS_NOT_MATCH = "003008";
    public static final String VALIDATE_GRN_STATUS_NOT_MATCH_DESC = "Current status (%s) of GRN is not valid for activity %s.";
    public static final String VALIDATE_BUYER_RECIPIENT_NOT_FOUND = "0030089";
    public static final String VALIDATE_BUYER_RECIPIENT_NOT_FOUND_DESC = "The Buyer [%s] does not set the recipient of the %s.";
    public static final String VALIDATE_SUPPLIER_RECIPIENT_NOT_FOUND = "0030090";
    public static final String VALIDATE_SUPPLIER_RECIPIENT_NOT_FOUND_DESC = "The Supplier [%s] does not set the recipient of the %s.";
    public static final String SERVICE_BEAN_NOT_FOUND = "002033";
    public static final String SERVICE_BEAN_NOT_FOUND_DESC  = "Service bean was not found.";
    public static final String VALIDATOR_PARAM_ILLEGAL = "012003";
    public static final String VALIDATOR_PARAM_ILLEGAL_DESC = "Param [%s] is empty or illegal.";
    public static final String VALIDATOR_FIELD_ILLEGAL = "012004";
    public static final String VALIDATOR_FIELD_ILLEGAL_DESC = "Field [%s] is empty or illegal.";
    public static final String REST_CLIENT_API_EXCEPTION = "999998";

}
