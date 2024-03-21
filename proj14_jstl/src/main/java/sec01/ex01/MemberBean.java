package sec01.ex01;

public class MemberBean {
   private String id;
   private String pwd;
   private String name;
   private String email;
   
   public MemberBean() {
      System.out.println("MemberBean 실행");
   }
   
   public String getId() {
      System.out.println("getId 실행 | this.id : " + this.id);
      return id;
   }
   public void setId(String id) {
      System.out.println("setId 실행 | id : " + id);
      this.id = id;
   }
   public String getPwd() {
      return pwd;
   }
   public void setPwd(String pwd) {
      System.out.println("setPwd 실행 | pwd : " + pwd);
      this.pwd = pwd;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
}
