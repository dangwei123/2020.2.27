public class Person implements Serializable {
    private static final long serialVersionUID=1L;

    private String name;
    private int age;
    private String sex;
    transient private int p;
    private static int count=100;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", p=" + p +
                '}';
    }
}

public class Test {
    //public static void main(String[] args) throws IOException {
        /*FileInputStream fis=new FileInputStream(path1);
        FileOutputStream fos=new FileOutputStream(path2);
        byte[] bytes=new byte[1024];
        while((fis.read(bytes))!=-1){
            fos.write(bytes);
        }
        fis.close();
        fos.close();*/

       /* BufferedInputStream bis=new BufferedInputStream
                (new FileInputStream(path1));
        BufferedOutputStream bos=new BufferedOutputStream
                (new FileOutputStream(path2));
        byte[] bytes=new byte[1024];
        while(bis.read(bytes)!=-1){
            bos.write(bytes);
        }
        bos.flush();
        bos.close();
        bis.close();
*/

        /*FileReader fr=new FileReader(path1);
        FileWriter fw=new FileWriter(file);
        int c=0;
        while((c=fr.read())!=-1){
            fw.write(c);
        }
        fr.close();
        fw.close();*/
        /*BufferedReader br=new BufferedReader
                (new FileReader(path1));
        BufferedWriter bw=new BufferedWriter
                (new FileWriter(path2));
        String c="";
        while((c=br.readLine())!=null){
            bw.write(c+"\r\n");
        }
        br.close();
        bw.close();*/
        /*BufferedInputStream bi=new BufferedInputStream
                (new FileInputStream(path1));
        BufferedOutputStream bo=new BufferedOutputStream
                (new FileOutputStream(path2));
        byte[] bytes=new byte[1024];
        while(bi.read(bytes)!=-1){
            bo.write(bytes);
        }
        bi.close();
        bo.close();*/

        String path="E://javacode//file//demo.txt";
        /*InputStream in=System.in;
        String s="";
        BufferedReader br=new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw=new BufferedWriter(new FileWriter(path));
        while((s=br.readLine())!=null){
            if("exit".equals(s)){
                break;
            }
            bw.write(s);
            bw.newLine();
            bw.flush();
        }*/

        /*String s="";
        OutputStream out=System.out;
        BufferedReader br=new BufferedReader
                (new FileReader(path));
        BufferedWriter bw=new BufferedWriter
                (new OutputStreamWriter(out));
        while((s=br.readLine())!=null){
            bw.write(s);
            bw.newLine();
            bw.flush();
        }

        bw.close();
        br.close();
*/
    //}
        public static void main(String[] args) throws IOException, ClassNotFoundException {
            serializable();
            Person p=rserializable();
            System.out.println(p);
            System.getProperties().list(System.out);
        }
        private static void serializable() throws IOException {
            Person p=new Person();
            p.setName("宝塔");
            p.setAge(21);
            p.setP(100);
            p.setSex("男");
            String path="E://javacode//file//demo.txt";
            ObjectOutputStream oos=new ObjectOutputStream
                    (new FileOutputStream(path));
            oos.writeObject(p);
            System.out.println("序列化成功");
            oos.close();
        }

        private static Person rserializable() throws IOException, ClassNotFoundException {
            String path="E://javacode//file//demo.txt";
            ObjectInputStream ois=new ObjectInputStream
                    (new FileInputStream(path));
            Person p=(Person)ois.readObject();
            System.out.println("反序列化成功");
            return p;
        }
}
