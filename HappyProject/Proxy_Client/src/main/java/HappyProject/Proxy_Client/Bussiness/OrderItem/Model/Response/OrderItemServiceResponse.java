package HappyProject.Proxy_Client.Bussiness.OrderItem.Model.Response;

import HappyProject.Proxy_Client.Bussiness.OrderItem.Model.DTO.OrderItemDTO;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

public class OrderItemServiceResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Collection<OrderItemDTO> orderItemDTOs;
}
