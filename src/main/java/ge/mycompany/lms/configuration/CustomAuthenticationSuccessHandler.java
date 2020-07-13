package ge.mycompany.lms.configuration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ge.mycompany.lms.usermanagement.entities.LmsUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();

        ObjectNode childNode = mapper.createObjectNode();
        LmsUserDetails principal = (LmsUserDetails) authentication.getPrincipal();
        childNode.put("username", principal.getUsername());
//        childNode.put("authorities", ((LmsUserDetails)authentication.getPrincipal()).getAuthorities());
        ArrayNode authorities = childNode.putArray("authorities");
        for(GrantedAuthority simpleGrantedAuthority : principal.getAuthorities()){
            authorities.add(simpleGrantedAuthority.getAuthority());
        }

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(childNode.toString());
        out.flush();

    }
}
