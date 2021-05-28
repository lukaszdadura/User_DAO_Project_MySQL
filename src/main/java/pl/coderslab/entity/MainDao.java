package pl.coderslab.entity;

public class MainDao {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUserName("amlkrevf");
        user.setEmail("arkadilkkjfgfdfvdfumszvv.jozwia@coderslab.pl");
        user.setPassword("pavlkmvs");
        userDao.create(user);

        User secondUser = new User();
        secondUser.setUserName("marek");
        secondUser.setEmail("maredggk@coderslab.pl");
        secondUser.setPassword("pass");
        userDao.create(secondUser);
        User[] all = userDao.findAll();
        for (User u : all) {
                System.out.println(u);
            }


//        User read = userDao.read(2);
//        System.out.println(read);
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
