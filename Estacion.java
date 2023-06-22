public class Estacion {
    private String apiStatus;
    private String time;
    private String issues;
    private Linea linea;

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

    public String getIssues() {
        return issues;
    }

    public void setIssues(String issues) {
        this.issues = issues;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    public static class Linea {
        private String name;
        private String id;
        private String issues;
        private String stationsClosedBySchedule;
        private EstacionDetalle estacionDetalle;

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

        public String getIssues() {
            return issues;
        }

        public void setIssues(String issues) {
            this.issues = issues;
        }

        public String getStationsClosedBySchedule() {
            return stationsClosedBySchedule;
        }

        public void setStationsClosedBySchedule(String stationsClosedBySchedule) {
            this.stationsClosedBySchedule = stationsClosedBySchedule;
        }

        public EstacionDetalle getEstacionDetalle() {
            return estacionDetalle;
        }

        public void setEstacionDetalle(EstacionDetalle estacionDetalle) {
            this.estacionDetalle = estacionDetalle;
        }
    }

    public static class EstacionDetalle {
        private String name;
        private String id;
        private String status;
        private String lines;
        private String description;
        private String isClosedBySchedule;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLines() {
            return lines;
        }

        public void setLines(String lines) {
            this.lines = lines;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String isClosedBySchedule() {
            return isClosedBySchedule;
        }

        public void setClosedBySchedule(String closedBySchedule) {
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

    public String toStringSingleLine() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(apiStatus).append(",");
        stringBuilder.append(time).append(",");
        stringBuilder.append(issues).append(",");

        if (linea != null) {
            stringBuilder.append(linea.getName()).append(",");
            stringBuilder.append(linea.getId()).append(",");
            stringBuilder.append(linea.getIssues()).append(",");
            stringBuilder.append(linea.getStationsClosedBySchedule()).append(",");

            if (linea.getEstacionDetalle() != null) {
                EstacionDetalle estacionDetalle = linea.getEstacionDetalle();
                stringBuilder.append(estacionDetalle.getName()).append(",");
                stringBuilder.append(estacionDetalle.getId()).append(",");
                stringBuilder.append(estacionDetalle.getStatus()).append(",");
                stringBuilder.append(estacionDetalle.getLines()).append(",");
                stringBuilder.append(estacionDetalle.getDescription()).append(",");
                stringBuilder.append(estacionDetalle.isClosedBySchedule()).append(",");

                Horario horario = estacionDetalle.getSchedule();
                if (horario != null) {
                    stringBuilder.append(horario.getOpen().getWeekdays()).append(",");
                    stringBuilder.append(horario.getOpen().getSaturday()).append(",");
                    stringBuilder.append(horario.getOpen().getHolidays()).append(",");
                    stringBuilder.append(horario.getClose().getWeekdays()).append(",");
                    stringBuilder.append(horario.getClose().getSaturday()).append(",");
                    stringBuilder.append(horario.getClose().getHolidays());
                }
            }
        }

        return stringBuilder.toString();
    }
}
