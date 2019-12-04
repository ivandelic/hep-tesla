package hr.hep.tesla.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TeslaExceptionMapper implements ExceptionMapper<TeslaException> {

	@Override
	public Response toResponse(TeslaException exception) {
		return Response.status(Status.BAD_REQUEST).entity(exception.getMessageCodes()).build();
	}

}
