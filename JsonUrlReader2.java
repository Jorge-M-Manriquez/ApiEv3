package org.apache.beam.examples;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonUrlReader2 {

    public JsonUrlReader2() {

    }

    public ArrayList<Estacion> cargarURL() throws StreamReadException, DatabindException, MalformedURLException, IOException {
        String url = "https://api.xor.cl/red/metro-network";

        ArrayList<Estacion> estaciones = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        System.out.println("Iniciando mapper en JsonUrlReader");
        JsonNode node = mapper.readTree(new URL(url));

        System.out.println("Finalizando mapper en JsonUrlReader");

        Iterator<JsonNode> it = node.iterator();

        Estacion estacion = new Estacion();
        estacion.setApiStatus("API STATUS");
        estacion.setTime("TIME");
        estacion.setIssues(false);
        estacion.setLines(new ArrayList<>());

        estaciones.add(estacion);

        int i = 1;
        while (it.hasNext()) {
            JsonNode n = it.next();

            Estacion.Linea linea = new Estacion.Linea();
            linea.setName("LINE NAME");
            linea.setId("LINE ID");
            linea.setIssues(false);
            linea.setStationsClosedBySchedule(0);
            linea.setStations(new ArrayList<>());

            estacion.getLines().add(linea);

            JsonNode r = n.get("realtime");
            Iterator<JsonNode> itRealTime = r.iterator();
            while (itRealTime.hasNext()) {
                JsonNode nRealTime = itRealTime.next();

                Estacion.EstacionDetalle estacionDetalle = new Estacion.EstacionDetalle();
                estacionDetalle.setName("ESTACION NAME");
                estacionDetalle.setId("ESTACION ID");
                estacionDetalle.setStatus(0);
                estacionDetalle.setLines(new ArrayList<>());
                estacionDetalle.setDescription("ESTACION DESCRIPTION");
                estacionDetalle.setClosedBySchedule(false);
                estacionDetalle.setSchedule(new Estacion.Horario());

                linea.getStations().add(estacionDetalle);

                // Setear los valores correspondientes en estacionDetalle
                // Utilizar nRealTime y nTableRow para obtener los valores

                i++;
            }
        }

        return estaciones;
    }
}
