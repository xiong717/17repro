package thread.thread0522;

public class ThreadLocalDemo75 {

    static class User{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {


    }
    class UserStorage {
        private  ThreadLocal<User> userThreadLocal = new ThreadLocal(){
            @Override
            protected User initialValue() {
                User user = new User();
                user.setName("bit");
                return user;
            }
        };
        public User getuser(){
            User user = new User();
            user.setName("bit");
            return user;
        }
    }
    /*
    * 仓储类
    * */
    class Storage{
        private void printname(User user){
            System.out.println(user.getName());
        }

        private void printname2(){
            System.out.println(new UserStorage().getuser().getName());
        }


    }
}
