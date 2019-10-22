package com.fast2.rest.utbildning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.fast2.rest.exception.utbildning.BusinessException;
import com.fast2.rest.utbildning.model.Arbetsorder;

@Service
public class ArbetsorderServiceImpl implements ArbetsorderService {

	Map<Long, Arbetsorder> arbetsorders = new HashMap<>();
	long currentId = 123;

	public ArbetsorderServiceImpl() {
		init();
	}

	public void init() {
		Arbetsorder arbetsorder = new Arbetsorder();
		arbetsorder.setId(currentId);
		arbetsorder.setName("fix utrymme");
		arbetsorders.put(currentId, arbetsorder);
	}

	@Override
	public List<Arbetsorder> getArbetsorders() {
		Collection<Arbetsorder> result = arbetsorders.values();
		ArrayList<Arbetsorder> respond = new ArrayList<>(result);
		return respond;
	}

	@Override
	public Arbetsorder getArbetsorder(long id) throws BusinessException {
		if(arbetsorders.get(id)== null) {
			BusinessException businessException = new BusinessException();
			businessException.setFriendlyMessage("Arbetsorder med " + id + " hittade ej");
			businessException.setErrorCode(Response.Status.NOT_FOUND.getStatusCode());
			throw businessException;
		}
		return arbetsorders.get(id);
	}

	@Override
	public Response creteArbetsorder(Arbetsorder Arbetsorder) {
		Arbetsorder.setId(++currentId);
		arbetsorders.put(Arbetsorder.getId(), Arbetsorder);
		// send 200 ok
		return Response.ok(Arbetsorder).build();
	}

	@Override
	public Response updateArbetsorder(Arbetsorder Arbetsorder) throws BusinessException  {
		Arbetsorder CurrentArbetsorder = arbetsorders.get(Arbetsorder.getId());
		if (CurrentArbetsorder != null) {
			arbetsorders.put(CurrentArbetsorder.getId(), Arbetsorder);
			return Response.ok(Arbetsorder).build();
		} else {
			BusinessException businessException = new BusinessException();
			businessException.setFriendlyMessage("Arbetsorder :" + Arbetsorder.getId() + " saknas");
			throw businessException;	
		}

	}

	@Override
	public Response deleteArbetsorder(long id) {
		Arbetsorder arbetsorder = arbetsorders.get(id);
		Response response;
		if (arbetsorder != null) {
			arbetsorders.remove(id);
			return response = Response.ok().build();
		}
		return response = Response.notModified().build();
	}

	//BadRequestException
	//NotAuthorizedException
	//ForbiddenException
	//internalServerException 
}
