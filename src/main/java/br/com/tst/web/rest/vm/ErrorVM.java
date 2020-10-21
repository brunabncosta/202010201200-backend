package br.com.tst.web.rest.vm;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ErrorVM implements Serializable {

	//TODO Retirar getters e setters verifiar lombock ao final
	
    private static final long serialVersionUID = 1L;

    private LocalDateTime timestamp;

    private Integer status;

    public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getTrace() {
		return trace;
	}

	public void setTrace(Object trace) {
		this.trace = trace;
	}

	public Map<String, Object> getViolations() {
		return violations;
	}

	public void setViolations(Map<String, Object> violations) {
		this.violations = violations;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	private String error;

    private String message;

    private Object trace;

    @JsonInclude(Include.NON_NULL)
    private Map<String, Object> violations;

    private String path;

    public ErrorVM(HttpStatus httpStatus) {
        timestamp = LocalDateTime.now();
        status = httpStatus.value();
        error = httpStatus.getReasonPhrase();
    }

    public void addViolation(String key, Object value) {
        if (violations == null) {
            violations = new HashMap<>();
        }
        violations.put(key, value);
    }
}
