package pl.coderslab.entity;

public class MainDao {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setUserName("Ania");
//        user.setEmail("ania@ania.pl");
//        user.setPassword("ania123");
//        userDao.create(user);
//
        UserDao userDao1 = new UserDao();
//        User user1 = new User();
//        user.setUserName("Adam");
//        user.setEmail("adam@adam.pl");
//        user.setPassword("adam123");
//        userDao.create(user);
//
        UserDao userDao2 = new UserDao();
//        User user2 = new User();
//        user.setUserName("Wojtek");
//        user.setEmail("wojtek@wojtek.pl");
//        user.setPassword("wojtek123");
//        userDao.create(user);
//
        UserDao userDao3 = new UserDao();
//        User user3 = new User();
//        user.setUserName("Piotr");
//        user.setEmail("piotr@piotr.pl");
//        user.setPassword("piotr123");
//        userDao.create(user);

//        User secondUser = new User();
//        secondUser.setUserName("marek");
//        secondUser.setEmail("maredggk@coderslab.pl");
//        secondUser.setPassword("pass");
//        userDao.create(secondUser);
//        User[] all = userDao.findAll();
//        for (User u : all) {
//                System.out.println(u);
//            }


        User read = userDao.read(3);
        System.out.println(read);
//
//        User readNotExist = userDao.read(6);
//        System.out.println(readNotExist);
//
//        User userToUpdate = userDao.read(1);
//        userToUpdate.setUserName("Arkadiusz");
//        userToUpdate.setEmail("arek@coderslab.pl");
//        userToUpdate.setPassword("superPassword");
//        userDao.update(userToUpdate);
//
//        userDao.delete(1);
//        userDao.delete(2);
    }
}
