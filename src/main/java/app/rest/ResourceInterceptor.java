package app.rest;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
@PreMatching
public class ResourceInterceptor implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) {
        // Obter o token de autenticação do cabeçalho da solicitação
        String token = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Verificar se o token é válido
        if (!usuarioTemPermissao(token)) {
            // Se o token for inválido ou o usuário não tiver permissão, enviar uma resposta de não autorizado
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    public boolean usuarioTemPermissao(String token) {
        return "TOKEN_AUTHORIZATION".equals(token);
    }
}