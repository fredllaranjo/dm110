package br.inatel.fredlaranjo.dm110.poller.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.inatel.fredlaranjo.dm110.poller.api.model.DeviceModel;

@Path("/poller")
public interface PollerService {

	@GET
	@Path("/start/{IP}/{MASK}")
	@Produces(MediaType.TEXT_PLAIN)
	void startPollDevices(@PathParam("IP") String ip, @PathParam("MASK") int mask);

	@GET
	@Path("/status/{IP}")
	@Produces(MediaType.APPLICATION_JSON)
	DeviceModel getDeviceStatus(@PathParam("IP") String ip);

}
