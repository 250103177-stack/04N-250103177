public class proxy_practice {
    interface Show {
        void show();
    }

    static class Image implements Show {
        String fileName;

        Image(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void show() {
            System.out.println("Access is given to " + fileName);
        }
    }

    static class ProxyImage implements Show {
        Image image;
        String fileName;
        String userRole;

        ProxyImage(String userRole, String fileName) {
            this.userRole = userRole;
            this.fileName = fileName;
        }

        @Override
        public void show() {
            if (userRole.equals("Admin")) {
                image = new Image(fileName);
                image.show();
            } else {
                System.out.println("Access denied");
            }
        }
    }

    public static void main(String[] args) {
        Show adminImage = new ProxyImage("Admin", "photo.jpg");
        adminImage.show();

        Show studentImage = new ProxyImage("Student", "secret.jpg");
        studentImage.show();
    }
}