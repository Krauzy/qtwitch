package dev.api.application.inbound.swagger;

import dev.api.application.inbound.dto.request.CreateUserRequest;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/user")
@Tag(name = "User", description = "User operations.")
public interface UserSwagger {

	// User

	@POST
	@Operation(summary = "Create new user", description = "Operation to create new user.")
	@APIResponses(value = {
		@APIResponse(
			responseCode = "201",
			name = "Created",
			description = "New user created successfully."
		)
	})
	Response createUser(@Valid @RequestBody CreateUserRequest body);

	@GET
	@Operation(summary = "List users", description = "Operation to list users.")
	@APIResponses(value = {
		@APIResponse(
			responseCode = "200",
			name = "Users",
			description = "List of existent users."
		)
	})
	Response listUser();
}
