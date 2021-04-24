package Entity;
import Types.UserType;
import java.time.LocalDate;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private float balance;
    private UserType type;
    private LocalDate createdAt;

    public User(String name, String email, float balance, UserType type, LocalDate createdAt) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.type = type;
        this.createdAt = createdAt;
    }

    public UUID getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public float getBalance(){
        return balance;
    }

    public UserType getType() {
        return type;
    }

    public LocalDate getCreatedAt(){
        return createdAt;
    }

    public void setBalance(float newBalance) {
        this.balance = newBalance;
    }
}



