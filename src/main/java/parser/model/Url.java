package parser.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "urls")
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String url;
    private int nestingLevel;
    private long countOfExternalHrefs;

    public Url() {
    }

    public Url(int nestingLevel) {
        this.nestingLevel = nestingLevel;
    }

    public Url(String url, int nestingLevel) {
        this.url = url;
        this.nestingLevel = nestingLevel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNestingLevel() {
        return nestingLevel;
    }

    public void setNestingLevel(int nestingLevel) {
        this.nestingLevel = nestingLevel;
    }

    public long getCountOfExternalHrefs() {
        return countOfExternalHrefs;
    }

    public void setCountOfExternalHrefs(long countOfExternalHrefs) {
        this.countOfExternalHrefs = countOfExternalHrefs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Url url1 = (Url) o;
        return nestingLevel == url1.nestingLevel
                && countOfExternalHrefs == url1.countOfExternalHrefs
                && Objects.equals(url, url1.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, nestingLevel, countOfExternalHrefs);
    }

    @Override
    public String toString() {
        return "Url{"
                + "url='" + url + '\''
                + ", nestingLevel=" + nestingLevel
                + ", countOfExternalHrefs=" + countOfExternalHrefs
                + '}';
    }
}
