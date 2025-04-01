package dev.api.application.inbound.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.validator.constraints.Length;

@Schema(name = "Content Creator", description = "Content creator request body.")
public record CreateContentCreatorRequest(
	@Schema(name = "name", description = "Content creator name.", examples = "John Doe")
	@NotBlank(message = "{request.creator.name.empty}")
	@Length(max = 200, message = "{request.creator.name.length}")
	String name,

	@Schema(name = "bio", description = "Content creator bio.", examples = "...")
	@Length(max = 5000, message = "{request.creator.bio.length}")
	String bio
) {
}
