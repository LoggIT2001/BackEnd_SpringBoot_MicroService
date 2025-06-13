package HappyProject.Order_Service.Constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class AppConstant {
    public static final String LOCAL_DATE_FORMAT = "dd-MM-yyyy";
    public static final String LOCAL_DATE_TIME_FORMAT = "dd-MM-yyyy__HH:mm:ss:SSSSSS";
    public static final String ZONED_DATE_TIME_FORMAT = "dd-MM-yyyy__HH:mm:ss:SSSSSS";
    public static final String INSTANT_FORMAT = "dd-MM-yyyy__HH:mm:ss:SSSSSS";

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public abstract class DiscoveredDomainsAPI{
        public static final String USER_SERVICE_HOST = "http://UserService/User_Service";
        public static final String USER_SERVICE_API_URL = "http://UserService/User_Service/api/users";

        public static final String PRODUCT_SERVICE_HOST = "http://ProductService/Product_Service";
        public static final String PRODUCT_SERVICE_API_URL = "http://ProductService/Product_Service/api/products";

        public static final String ORDER_SERVICE_HOST = "http://OrderService/Order_Service";
        public static final String ORDER_SERVICE_API_URL = "http://OrderService/Order_Service/api/orders";

        public static final String PAYMENT_SERVICE_HOST = "http://PaymentService/Payment_Service";
        public static final String PAYMENT_SERVICE_API_URL = "http://PaymentService/Payment_Service/api/payments";

        public static final String RATING_SERVICE_HOST = "http://RatingService/Rating_Service";
        public static final String RATING_SERVICE_API_URL = "http://RatingService/Rating_Service/api/ratings";
    }
}
