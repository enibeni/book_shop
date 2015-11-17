package shop.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import shop.domain.Customer;
import shop.domain.Orders;
import shop.domain.OrdersProduct;
import shop.domain.Product;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "/spring/business-config.xml"})

public class CustomerDaoImplTest {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private OrdersProductDao ordersProductDao;

    @Test
    public void testAddCustomer() throws Exception {
        //Customers

        Customer customer1 = new Customer();
        customer1.setName("Serega1");
        customer1.setEmail("ivan@petrov.ru");
        customerDao.addCustomer(customer1);
//        Customer customer2 = new Customer();
//        customer2.setName("Serega2");
//        Customer customer3 = new Customer();
//        customer3.setName("Serega3");
//
//        customerDao.addCustomer(customer1);
//        customerDao.addCustomer(customer2);
//        customerDao.addCustomer(customer3);
//
//        System.out.println("Added customer: " + customer1.getName() + customer1.getId());
//        System.out.println("Added customer: " + customer2.getName() + customer2.getId());
//        System.out.println("Added customer: " + customer3.getName() + customer3.getId());


        //Products
        /*Product product1 = new Product();
        product1.setTitle("Молоко");
        product1.setPrice(100);
        Product product2 = new Product();
        product2.setTitle("Кефир");
        product2.setPrice(50);
        Product product3 = new Product();
        product3.setTitle("Сметана");
        product3.setPrice(120.3f);
        Product product4 = new Product();
        product4.setTitle("Тан");
        product4.setPrice(100);
        Product product5 = new Product();
        product5.setTitle("Творог");
        product5.setPrice(90);
        Product product6 = new Product();
        product6.setTitle("Йогурт");
        product6.setPrice(70.50f);

        productDao.add(product1);
        productDao.add(product2);
        productDao.add(product3);
        productDao.add(product4);
        productDao.add(product5);
        productDao.add(product6);

        System.out.println(product1.getId());
        productDao.delete(product1.getId());*/
    }

    @Test
    public void ManyToManyExtraColumn() throws Exception {
        Product product1 = new Product();
        product1.setTitle("Moloko");
        product1.setPrice(90);
        product1.setAuthor("savvsav");
        Product product2 = new Product();
        product2.setTitle("Tan");
        product2.setPrice(60);
        product2.setAuthor("svlvlsa");

        productDao.add(product1);
        productDao.add(product2);


        //Customers
        Customer customer1 = new Customer();
        customer1.setName("Serega1");

        customerDao.addCustomer(customer1);

        Orders order1 = new Orders();
        order1.setCustomer(customer1);
        ordersDao.add(order1);


        OrdersProduct ordersProduct1 = new OrdersProduct();
        ordersProduct1.setOrders(order1);
        ordersProduct1.setProduct(product1);
        ordersProduct1.setQuntity(3);

        order1.getOrdersProducts().add(ordersProduct1);

        ordersProductDao.add(ordersProduct1);
    }

    @Test
    public void getAll() throws Exception{
        System.out.printf("_______________");
        System.out.println("=333" + productDao.getAll());
    }

    @Test
    public void findProductById() throws Exception{
        System.out.println(productDao.findById(1).getTitle());
    }

    @Test
    public void AddBooks() throws Exception {
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();
        Product product6 = new Product();
        Product product7 = new Product();
        Product product8 = new Product();
        Product product9 = new Product();
        Product product10 = new Product();
        Product product11 = new Product();
        Product product12 = new Product();
        Product product13 = new Product();

        /*product1.setTitle("Harry Potter");
        product1.setPrice(390);
        product1.setAuthor("J. Rouling");
        product2.setTitle("The art of war");
        product2.setPrice(460);
        product2.setAuthor("Sun Tzu");
        product3.setTitle("Thinking in java");
        product3.setPrice(470);
        product3.setAuthor("Bruce Eckel");*/

        product1.setTitle("Страшные рассказы");
        product1.setPrice(390);
        product1.setAuthor("Эдгар Аллан По");
        /*product2.setTitle("Убить пересмешника...");
        product2.setPrice(460);
        product2.setAuthor("Харпер Ли");
        product3.setTitle("До встречи с тобой");
        product3.setPrice(340);
        product3.setAuthor("Джоджо Мойес");
        product4.setTitle("Горькая радость");
        product4.setPrice(430);
        product4.setAuthor("Колин Маккалоу");
        product5.setTitle("Тайная история");
        product5.setPrice(450);
        product5.setAuthor("Донна Тартт");
        product6.setTitle("Имя Розы");
        product6.setPrice(540);
        product6.setAuthor("Умберто Эко");
        product7.setTitle("Уличный кот по имени Боб");
        product7.setPrice(250);
        product7.setAuthor("Джеймс Боуэн");
        product8.setTitle("Весь невидимый нам свет");
        product8.setPrice(630);
        product8.setAuthor("Энтони Дорр");
        product9.setTitle("Устал рождаться и умирать");
        product9.setPrice(430);
        product9.setAuthor("Мао Янь");
        product10.setTitle("Мастер и Маргарита.");
        product10.setPrice(260);
        product10.setAuthor("Михаил Булгаков");
        product11.setTitle("Белая гвардия");
        product11.setPrice(260);
        product11.setAuthor("Михаил Булгаков");
        product12.setTitle("Собачье сердце");
        product12.setPrice(260);
        product12.setAuthor("Михаил Булгаков");
        product13.setTitle("Повести и рассказы");
        product13.setPrice(260);
        product13.setAuthor("Михаил Булгаков");*/


        productDao.add(product1);
        //productDao.add(product2);
        //productDao.add(product3);
/*        productDao.add(product4);
        productDao.add(product5);
        productDao.add(product6);
        productDao.add(product7);
        productDao.add(product8);
        productDao.add(product9);
        productDao.add(product10);
        productDao.add(product11);
        productDao.add(product12);
        productDao.add(product13);*/

    }

}




        //ordersDao.addOrder(order1.getId(), product1.getId());
        //order1.setCustomer(customer1);
        //order1.setProduct(Arrays.asList(productDao.findById(product1.getId()), productDao.findById(product2.getId())));
        //ordersDao.add(order1);
        //ordersDao.addOrder(order1.getId(), product1.getId());
        //order1.setCustomer(customerDao.findById(customer1.getId()));
        //order1.setProduct(Arrays.asList(product1, product3));
        //Orders order2 = new Orders();
        //order2.setCustomer(customerDao.findById(customer2.getId()));
        //order2.setProduct(Arrays.asList(product3, product5, product6));
        //Orders order3 = new Orders();
        //order3.setCustomer(customerDao.findById(customer3.getId()));
        //order3.setProduct(Arrays.asList(product1, product5));


        //ordersDao.add(order2);
        //ordersDao.add(order3);
//
//        ordersDao.addOrder(order1.getId(), product1.getId());
//        ordersDao.addOrder(order1.getId(), product1.getId());

        //System.out.println(dao.getAll());
