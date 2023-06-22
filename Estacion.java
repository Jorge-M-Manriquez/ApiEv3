public class Estacion {
    private String apiStatus;
    private String time;
    private boolean issues;
    private List<Linea> lines;

    public String getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(String apiStatus) {
        this.apiStatus = apiStatus;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isIssues() {
        return issues;
    }

    public void setIssues(boolean issues) {
        this.issues = issues;
    }

    public List<Linea> getLines() {
        return lines;
    }

    public void setLines(List<Linea> lines) {
        this.lines = lines;
    }

    public static class Linea {
        private String name;
        private String id;
        private boolean issues;
        private int stationsClosedBySchedule;
        private List<EstacionDetalle> stations;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIssues() {
            return issues;
        }

        public void setIssues(boolean issues) {
            this.issues = issues;
        }

        public int getStationsClosedBySchedule() {
            return stationsClosedBySchedule;
        }

        public void setStationsClosedBySchedule(int stationsClosedBySchedule) {
            this.stationsClosedBySchedule = stationsClosedBySchedule;
        }

        public List<EstacionDetalle> getStations() {
            return stations;
        }

        public void setStations(List<EstacionDetalle> stations) {
            this.stations = stations;
        }
    }

    public static class EstacionDetalle {
        private String name;
        private String id;
        private int status;
        private List<String> lines;
        private String description;
        private boolean isClosedBySchedule;
        private Horario schedule;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public List<String> getLines() {
            return lines;
        }

        public void setLines(List<String> lines) {
            this.lines = lines;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isClosedBySchedule() {
            return isClosedBySchedule;
        }

        public void setClosedBySchedule(boolean closedBySchedule) {
            isClosedBySchedule = closedBySchedule;
        }

        public Horario getSchedule() {
            return schedule;
        }

        public void setSchedule(Horario schedule) {
            this.schedule = schedule;
        }
    }

    public static class Horario {
        private HorarioDia open;
        private HorarioDia close;

        public HorarioDia getOpen() {
            return open;
        }

        public void setOpen(HorarioDia open) {
            this.open = open;
        }

        public HorarioDia getClose() {
            return close;
        }

        public void setClose(HorarioDia close) {
            this.close = close;
        }
    }

    public static class HorarioDia {
        private String weekdays;
        private String saturday;
        private String holidays;

        public String getWeekdays() {
            return weekdays;
        }

        public void setWeekdays(String weekdays) {
            this.weekdays = weekdays;
        }

        public String getSaturday() {
            return saturday;
        }

        public void setSaturday(String saturday) {
            this.saturday = saturday;
        }

        public String getHolidays() {
            return holidays;
        }

        public void setHolidays(String holidays) {
            this.holidays = holidays;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estacion{")
                .append("apiStatus='").append(apiStatus).append('\'')
                .append(", time='").append(time).append('\'')
                .append(", issues=").append(issues)
                .append(", lines=[");

        if (lines != null) {
            for (Linea linea : lines) {
                sb.append("{")
                        .append("name='").append(linea.getName()).append('\'')
                        .append(", id='").append(linea.getId()).append('\'')
                        .append(", issues=").append(linea.isIssues())
                        .append(", stationsClosedBySchedule=").append(linea.getStationsClosedBySchedule())
                        .append(", stations=[");

                if (linea.getStations() != null) {
                    for (EstacionDetalle estacionDetalle : linea.getStations()) {
                        sb.append("{")
                                .append("name='").append(estacionDetalle.getName()).append('\'')
                                .append(", id='").append(estacionDetalle.getId()).append('\'')
                                .append(", status=").append(estacionDetalle.getStatus())
                                .append(", lines=").append(estacionDetalle.getLines())
                                .append(", description='").append(estacionDetalle.getDescription()).append('\'')
                                .append(", isClosedBySchedule=").append(estacionDetalle.isClosedBySchedule())
                                .append(", schedule={");

                        Horario horario = estacionDetalle.getSchedule();
                        if (horario != null) {
                            sb.append("open={")
                                    .append("weekdays='").append(horario.getOpen().getWeekdays()).append('\'')
                                    .append(", saturday='").append(horario.getOpen().getSaturday()).append('\'')
                                    .append(", holidays='").append(horario.getOpen().getHolidays()).append('\'')
                                    .append("}, close={")
                                    .append("weekdays='").append(horario.getClose().getWeekdays()).append('\'')
                                    .append(", saturday='").append(horario.getClose().getSaturday()).append('\'')
                                    .append(", holidays='").append(horario.getClose().getHolidays()).append('\'')
                                    .append("}");
                        }

                        sb.append("}}");
                    }
                }

                sb.append("]}, ");
            }
        }

        sb.append("]}");

        return sb.toString();
    }

    public String toStringSingleLine() {
        List<String> valuesList = new ArrayList<>();

        valuesList.add(apiStatus);
        valuesList.add(time);
        valuesList.add(String.valueOf(issues));

        if (lines != null) {
            for (Linea linea : lines) {
                valuesList.add(linea.getName());
                valuesList.add(linea.getId());
                valuesList.add(String.valueOf(linea.isIssues()));
                valuesList.add(String.valueOf(linea.getStationsClosedBySchedule()));

                if (linea.getStations() != null) {
                    for (EstacionDetalle estacionDetalle : linea.getStations()) {
                        valuesList.add(estacionDetalle.getName());
                        valuesList.add(estacionDetalle.getId());
                        valuesList.add(String.valueOf(estacionDetalle.getStatus()));
                        valuesList.add(String.join(",", estacionDetalle.getLines()));
                        valuesList.add(estacionDetalle.getDescription());
                        valuesList.add(String.valueOf(estacionDetalle.isClosedBySchedule()));

                        Horario horario = estacionDetalle.getSchedule();
                        if (horario != null) {
                            valuesList.add(horario.getOpen().getWeekdays());
                            valuesList.add(horario.getOpen().getSaturday());
                            valuesList.add(horario.getOpen().getHolidays());
                            valuesList.add(horario.getClose().getWeekdays());
                            valuesList.add(horario.getClose().getSaturday());
                            valuesList.add(horario.getClose().getHolidays());
                        }
                    }
                }
            }
        }

        return String.join(",", valuesList);
    }
}