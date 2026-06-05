package org.library.model;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private String memberId;
    private String name;
    private String email;



    public Member(
            String memberId,
            String name,
            String email) {

        this.memberId = memberId;
        this.name = name;
        this.email = email;

        this.borrowHistory =
                new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    private List<BorrowRecord> borrowHistory =
            new ArrayList<>();

    public List<BorrowRecord> getBorrowHistory() {
        return borrowHistory;
    }
}