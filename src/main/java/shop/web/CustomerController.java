package shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import shop.domain.Customer;
import shop.presentation.ShopService;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class CustomerController {
    private ShopService shopService;

    @Autowired
    public CustomerController(ShopService shopService) {
        this.shopService = shopService;
    }

    @RequestMapping(value = "/customerAuthentication", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
        CustomerCommand command = new CustomerCommand();
        model.put("customer", command);
        return "customerAuthentication";
    }

    @RequestMapping(value = "/customer/new", method = RequestMethod.POST)
    public String processCreationForm(@ModelAttribute("customer") CustomerCommand customer,
                                      BindingResult result, SessionStatus status,
                                      HttpSession session) {
        if (result.hasErrors()) {
            return "customerAuthentication";
        } else {
            Customer customer1 = shopService.saveCustomer(customer.toCustomer());
            status.setComplete();
            session.setAttribute("customer", customer.toString());
            session.setAttribute("customerObj", customer1);
            return "confirm";
        }
    }
}
