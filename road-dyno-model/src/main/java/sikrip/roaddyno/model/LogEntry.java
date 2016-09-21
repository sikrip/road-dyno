package sikrip.roaddyno.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LogEntry {

	private final Map<String, LogValue<Double>> values;
	private final String timeKey;
	private final String velocityKey;

	public LogEntry(Map<String, LogValue<Double>> values, String timeKey, String velocityKey) {
		this.values = new HashMap<>(values);
		this.timeKey = timeKey;
		this.velocityKey = velocityKey;
	}

	public LogValue<Double> getTime() {
		return values.get(timeKey);
	}

	public LogValue<Double> getVelocity() {
		return values.get(velocityKey);
	}

	public LogValue<Double> get(String valueKey) {
		return values.get(valueKey);
	}

	public LogEntry getCopy() {
		Map<String, LogValue<Double>> valuesCopy = new HashMap<>();

		for (String valueKey : this.values.keySet()) {
			LogValue<Double> value = this.values.get(valueKey);
			valuesCopy.put(valueKey, new LogValue<>(value.getValue(), value.getUnit()));
		}

		return new LogEntry(valuesCopy, timeKey, velocityKey);
	}

	public Set<String> getDataKeys() {
		return values.keySet();
	}

	@Override
	public String toString() {
		final StringBuilder stringBuilder = new StringBuilder("LogEntry ");

		for (Map.Entry<String, LogValue<Double>> valueEntry : values.entrySet()) {
			stringBuilder.append(valueEntry.getKey()).append(": ").append(valueEntry.getValue()).append(" ");
		}

		return stringBuilder.toString();
	}
}
