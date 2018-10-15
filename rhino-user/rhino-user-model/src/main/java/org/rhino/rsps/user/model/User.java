package org.rhino.rsps.user.model;

import javax.persistence.*;

/**
 * The user's account. An account will not be created until the credentials have been verified.
 */
@Entity(name = "USER")
public class User {

    /**
     * The unique database ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USR_ID", nullable = false)
    private Long id;

    /**
     * The user's username, this can be different from the display name
     */
    @Column(name = "USR_USER_NAME", nullable = false)
    private String username;

    /**
     * The user's password, between 4 and 16 letters/numbers
     */
    @Column(name = "USR_PASSWORD", nullable = false)
    private String password;

    /**
     * The user's e-mail, mostly used for verification/recovery
     */
    @Column(name = "USR_EMAIL", nullable = false)
    private String email;

    /**
     * The unique verification token to activate the account. Is mainly only used for
     * recovery purposes and activating the account.
     */
    @Column(name = "USR_TOKEN", nullable = false)
    private String verificationToken;

    /**
     * Indicates the account is verified (AKA active)
     */
    @Column(name = "USR_VERIFIED", nullable = false)
    private boolean verified;

    /**
     * The user's display name.
     */
    @Column(name = "USR_DISPLAY_NAME", nullable = false)
    private String displayName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
