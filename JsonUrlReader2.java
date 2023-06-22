import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class JsonUrlReader2 {

    public JsonUrlReader2() {
    }

    public ArrayList<Estacion> cargarURL() throws StreamReadException, DatabindException, MalformedURLException, IOException {
        String url = "https://sinca.mma.gob.cl/index.php/json/listadomapa2k19/";

        ArrayList<> estaciones = neEstacionw ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        System.out.println("Inicando mapper en JsonUrlReader");
        JsonNode node = mapper.readTree(new URL(url));

        System.out.println("Finalizando mapper en JsonUrlReader");

        Iterator<JsonNode> it = node.iterator();

        int i = 1;
        while (it.hasNext()) {
            JsonNode n = it.next();

            Estacion estacion = new Estacion();
            estacion.setApiStatus("API_STATUS");
            estacion.setTime("TIME");
            estacion.setIssues("ISSUES");

            Estacion.Linea linea = new Estacion.Linea();
            linea.setName(n.get("nombre").asText());
            linea.setId(n.get("key").asText());
            linea.setIssues("ISSUES");
            linea.setStationsClosedBySchedule("STATIONS_CLOSED_BY_SCHEDULE");

            Estacion.EstacionDetalle estacionDetalle = new Estacion.EstacionDetalle();
            estacionDetalle.setName("NAME");
            estacionDetalle.setId("ID");
            estacionDetalle.setStatus("STATUS");
            estacionDetalle.setLines("LINES");
            estacionDetalle.setDescription("DESCRIPTION");
            estacionDetalle.setClosedBySchedule("CLOSED_BY_SCHEDULE");

            Estacion.Horario horario = new Estacion.Horario();
            Estacion.HorarioDia open = new Estacion.HorarioDia();
            open.setWeekdays("WEEKDAYS");
            open.setSaturday("SATURDAY");
            open.setHolidays("HOLIDAYS");
            Estacion.HorarioDia close = new Estacion.HorarioDia();
            close.setWeekdays("WEEKDAYS");
            close.setSaturday("SATURDAY");
            close.setHolidays("HOLIDAYS");

            horario.setOpen(open);
            horario.setClose(close);
            estacionDetalle.setSchedule(horario);

            estacion.getLinea().setEstacionDetalle(estacionDetalle);
            estacion.setLinea(linea);

            estaciones.add(estacion);
            System.out.println(estacion);

            i++;
        }

        return estaciones;
    }
}
