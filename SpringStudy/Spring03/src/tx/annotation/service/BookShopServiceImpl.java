package tx.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tx.annotation.dao.BookShopDao;

@Service
public class BookShopServiceImpl implements BookShopService {

    @Autowired          //自动装配
    private BookShopDao bookShopDao;

    @Override
    public void buyBook(String username, String isbn) {
       Integer price= bookShopDao.findPriceByIsbn(isbn);

       bookShopDao.updateStock(isbn);

       bookShopDao.updateUserAccount(username,price);
    }
}
