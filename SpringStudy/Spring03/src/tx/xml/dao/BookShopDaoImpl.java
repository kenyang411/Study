package tx.xml.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tx.xml.exception.BookStockException;
import tx.xml.exception.UserAccountException;

@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer findPriceByIsbn(String isbn) {
        String sql = "SELECT price FROM book where isbn=? ";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    @Override
    public void updateStock(String isbn) {
        String sql = "SELECT stock FROM book_stock WHERE isbn=? ";
        Integer stock = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
        if (stock <= 0) {
            throw new BookStockException("库存不足...");
        }
        sql = "UPDATE book_stock set stock=stock-1 WHERE isbn=? ";
        jdbcTemplate.update(sql, isbn);
    }

    @Override
    public void updateUserAccount(String username, Integer price) {
        String sql = " SELECT balance FROM account WHERE username=? ";
        Integer balance = jdbcTemplate.queryForObject(sql, Integer.class, username);
        if (balance < price) {
            throw new UserAccountException("余额不足...");
        }
        sql = " UPDATE account set balance= balance-?  WHERE username=? ";
        jdbcTemplate.update(sql, price, username);
    }
}
