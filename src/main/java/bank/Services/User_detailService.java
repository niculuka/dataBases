package bank.Services;

import bank.GenericDao.HibernateUtil;
import bank.Model.User_details;

public class User_detailService {
    HibernateUtil<User_details> user_detailsHibernateUtil = new HibernateUtil();

    public void addUser_detail(User_details user_details) {
        user_detailsHibernateUtil.add(user_details);
    }

    public User_details readUserDetails(User_details user_details, int id) {
        return user_detailsHibernateUtil.readUserDetails(user_details, id);
    }


}
