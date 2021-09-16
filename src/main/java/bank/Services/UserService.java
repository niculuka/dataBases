package bank.Services;

import bank.GenericDao.HibernateUtil;
import bank.Model.User;

public class UserService {
    HibernateUtil<User> userHibernateUtil = new HibernateUtil();

    public void addUser(User user) {
        userHibernateUtil.add(user);
    }

    public void update(User user) {
        userHibernateUtil.update(user);
    }

    public User findById_User(User user, int id) {
        return userHibernateUtil.findById(user, id);
    }

    public void deleteUser(User user) {
        userHibernateUtil.delete(user);
    }
}
