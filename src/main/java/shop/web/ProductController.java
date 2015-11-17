package shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import shop.domain.Product;
import shop.exception.NotFoundException;
import shop.presentation.ApplicationException;
import shop.presentation.ShopService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    private ShopService shopService;

    @Autowired
    public ProductController(ShopService shopService) {
        this.shopService = shopService;
    }

    @RequestMapping(value = "/products/new", method = RequestMethod.GET)
    public String initCreationForm(Map<String, Object> model) {
        ProductCommand command = new ProductCommand();
        model.put("product", command);
        return "products/createOrUpdateProduct";
    }

    @RequestMapping(value = "/products/new", method = RequestMethod.POST)
    public String processCreationForm(@ModelAttribute("product") ProductCommand product, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "products/createOrUpdateProduct";
        } else {
            shopService.saveProduct(product.toProduct());
            status.setComplete();
            return "redirect:/products";
        }
    }

    @RequestMapping("/products")
    public String showProducts(Map<String, Object> model) throws ApplicationException {

        model.put("products", shopService.getAll());
        return "products";
    }


    @RequestMapping(value = "/products/{productId}/edit", method = RequestMethod.GET)
    public String initUpdateProductForm(@PathVariable("productId") int productId, Model model) {

        model.addAttribute("product", ProductCommand.fromProduct(shopService.findProductById(productId)));
        return "products/createOrUpdateProduct";
    }

    @RequestMapping(value = "/products/{productId}/delete", method = RequestMethod.GET)
    public String initDeleteProductForm(@PathVariable("productId") int productId) {
        try {
            shopService.delete(productId);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/products";
    }

    @RequestMapping(value = "/products/{productId}/view", method = RequestMethod.GET)
    public String initViewForm(@PathVariable("productId") int productId, Model model) {
        Product product = this.shopService.findProductById(productId);
        model.addAttribute(product);

        return "products/productForm";
    }

    @RequestMapping(value = "/addCart/{productId}", method = RequestMethod.POST)
    public String addCart(@PathVariable("productId") int productId,
                          HttpSession session) {
        List<Product> lst = (List<Product>) session.getAttribute("cart");
        Product product = this.shopService.findProductById(productId);
        if (lst == null) {
            lst = new ArrayList<Product>();
            lst.add(product);
        }else {                         //handling duplicate items in cart
            boolean flag = false;
            for (Product p : lst){
                if(product.getId() == p.getId()){
                    p.setQuantity(p.getQuantity() + 1);
                    flag = true;
                    break;
                }
            }
            if (!flag){
                lst.add(product);
            }

        }

        session.setAttribute("cart", lst);
        session.setAttribute("total", getTotal(lst));
        return "cart";
    }

    public float getTotal(List<Product> lst){
        float total = 0;
        for (Product p : lst){
            total += p.getPrice()*p.getQuantity();
        }
        return total;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(@RequestParam(value = "id") int id, HttpSession session) {
        List<Product> lst = (List<Product>) session.getAttribute("cart");
        if (lst != null) {
            for (Product p : lst) {
                if (p.getId() == id) {
                    lst.remove(p);
                    break;
                }
            }
        }
        session.setAttribute("cart", lst);
        session.setAttribute("total", getTotal(lst));
        return "cart";
    }

    @RequestMapping(value = "/addCart/modifyCount", method = RequestMethod.POST)
    public String modifyCount(@RequestParam(value = "id") int id,
                              @RequestParam String action, HttpSession session){
        List<Product> lst = (List<Product>) session.getAttribute("cart");
        if(lst != null){
            for (Product p : lst){
                if(p.getId() == id)
                {
                    if ("more".equals(action)) {
                        p.setQuantity(p.getQuantity() + 1);
                        break;
                    }
                    if ("less".equals(action)) {
                        if(p.getQuantity() > 1) {
                            p.setQuantity(p.getQuantity() - 1);
                            break;
                        }
                    }
                }
            }
        }
        session.setAttribute("cart", lst);
        session.setAttribute("total", getTotal(lst));
        return "cart";
    }

//    @RequestMapping(value = "/addCart/modify", method = RequestMethod.POST)
//    public String modifyCount(HttpServletRequest request, HttpServletResponse response, @RequestParam String action,
//                                   @ModelAttribute("cart") Product cart,
//                                   @RequestParam(value = "p.id") Integer productId,
//                                   @PathVariable("productQuantity") Integer quantity, Map<String, Object> model, HttpSession session) {
//        //handle cart
//        if ("more".equals(action)) {
//            model.put("quantity", quantity = (quantity + 1));
//        }
//        if ("less".equals(action)) {
//            model.put("quantity", quantity = (quantity - 1));
//        }
//
//        Product product = this.shopService.findProductById(productId);
//        List<Product> lst = (List<Product>) session.getAttribute("cart");
//        product.setQuantity(quantity);
//        session.setAttribute("cart", lst);
//
//
//
////        Cookie cookie = new Cookie("countercockie", String.valueOf(counter));
////        response.addCookie(cookie);
//
//        return "cart";
//    }


//    @RequestMapping(value = "/products/{productId}/addToCart", method = RequestMethod.GET)
//    public String initCartForm(@PathVariable("productId") int productId, Model model) {
//        Product product = this.shopService.findProductById(productId);
//        model.addAttribute(product);
//
//        return "cart";
//    }


}
