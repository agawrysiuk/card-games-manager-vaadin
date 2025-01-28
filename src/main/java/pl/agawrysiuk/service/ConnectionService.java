package pl.agawrysiuk.service;

import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.VaadinSessionScope;
import jakarta.servlet.http.Cookie;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringComponent
@VaadinSessionScope
public class ConnectionService {

    private static final String COOKIE_CONNECTION_PREFIX = "Connection.";
    private static final RestTemplate restTemplate = new RestTemplateBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .readTimeout(Duration.ofSeconds(10))
            .build();

    public String getConnectionIp(String serverName) {
        Cookie[] cookies = VaadinService.getCurrentRequest().getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(COOKIE_CONNECTION_PREFIX + serverName)) {
                return cookie.getValue();
            }
        }

        return null;
    }

    public Boolean setConnectionIp(String serverName, String serverIp) {
        Cookie cookie = new Cookie(COOKIE_CONNECTION_PREFIX + serverName, serverIp);
        VaadinService.getCurrentResponse().addCookie(cookie);
        return true;
    }

    public boolean testConnection(String ip) {
        try {
            restTemplate.getForEntity(ip, String.class);
            return true;
        } catch (ResourceAccessException e) {
            return false;
        }
    }
}
