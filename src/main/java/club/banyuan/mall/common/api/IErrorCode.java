package club.banyuan.mall.common.api;

public class IErrorCode {
    /**
     * 封装API的错误码
     */
    public interface IErrorCode {
        long getCode();

        String getMessage();
    }
}
