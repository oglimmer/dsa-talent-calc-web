package de.oglimmer.dsacalc.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import de.oglimmer.dsa.WinRateCalculator;

@Path("calc")
public class CalcResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PostOut post(PostIn postIn) {

		System.out.println(postIn);

		List<PostOutValue> resultList = new ArrayList<>();
		for (int taw = -10; taw < 16; taw++) {
			WinRateCalculator trsc = new WinRateCalculator(postIn.getValues(), taw, 20);
			resultList.add(new PostOutValue(taw, trsc.getWinRate()));
			// System.out.println("P(win) for TaW=" + taw + " == " + trsc.getWinRate() + "%");
		}

		return new PostOut(resultList.toArray(new PostOutValue[resultList.size()]));
	}

	@Data
	public static class PostIn {
		private int[] values;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class PostOut {
		private PostOutValue[] values;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class PostOutValue {
		private int taw;
		private double p;
	}

}
