package ku.cs.cafe.repository;

import org.springframework.stereotype.Repository;
import java.util.UUID;
import ku.cs.cafe.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {
    Member findByUsername(String username);
}
