package shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import shop.domain.Customer;
import shop.domain.Orders;
import shop.domain.Product;
import shop.exception.NotFoundException;
import shop.presentation.ShopService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by Enibeni on 02.12.2014.
 */
@Controller
public class OrderController {
    private ShopService shopService;

    @Autowired
    public OrderController(ShopService shopService) {
        this.shopService = shopService;
    }

    @RequestMapping(value = "/order/new", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
        OrderCommand command = new OrderCommand();
        model.put("order", command);
        return "products";
    }

    @RequestMapping(value = "/order/new", method = RequestMethod.POST)
    public String processCreationForm(@ModelAttribute("order") OrderCommand order,
                                      OrdersProductCommand OPCommand,
                                      BindingResult result, SessionStatus status,
                                      HttpSession session) {
        List<Product> lst = (List<Product>) session.getAttribute("cart");
        Customer customer = (Customer)session.getAttribute("customerObj");
        //Product product = this.shopService.findProductById(productId);
        if (result.hasErrors()) {
            return "products";
        } else {
            order.setCustomer(customer);
            Orders orders = shopService.saveOrder(order.toOrders());
            for (Product p : lst) {
                try {
                    OPCommand.setOrders(orders);
                    OPCommand.setProduct(p);
                    OPCommand.setQuantity(p.getQuantity());
                    shopService.saveOrdersProduct(OPCommand.toOrdersProduct());     //orderID = 0
                }catch (NotFoundException e){
                    e.printStackTrace();
                }

                status.setComplete();
            }
            session.setAttribute("orderId", orders.getId());
            return "congratulations";
        }
    }

    @RequestMapping(value = "/order/list", method = RequestMethod.GET)
    public String orderList(Map<String, Object> model) {
        model.put("order", shopService.getAllProducts());
        return "orders";
    }
}
