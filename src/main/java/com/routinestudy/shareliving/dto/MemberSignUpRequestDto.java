package com.routinestudy.shareliving.dto;

import com.routinestudy.shareliving.domain.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberSignUpRequestDto {

    @NotBlank(message = "아이디를 입력해주세요.")
    @Length(min = 5, max = 20, message = "아이디는 5~20자 이상입니다")
    private String username;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Length(min = 8, max = 16, message = "비밀번호는 8~16자 이상입니다")
    private String password;

    @NotBlank(message = "닉네임을 입력해주세요.")
    private String nickname;

    public Member toEntity() {
        return Member.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .insertId(username)
                .modifyId(username).build();
    }
}
