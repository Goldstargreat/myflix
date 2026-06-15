package kr.ac.kopo.gnuyog.myflix.model;

// 사용자(User) 정보를 저장하는 클래스(데이터 틀)
public class User
{
    private Long id; // 사용자 고유번호
    private String username; // 사용자 이름
    private String password; // 비밀번호
    private String role; // 권한

    // 기본 생성자
    public User()
    {
      // User라는 사용자 설계도 만들겠다
    }

    // 전체 값 받는 생성자
    public User(Long id, String username, String password, String role)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    // Getter (값 가져오기)
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getUsername()
    {
        return username;
    }
    // Setter (값 변경하기)
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getRole()
    {
        return role;
    }
    public void setRole(String role)
    {
        this.role = role;
    }
}
