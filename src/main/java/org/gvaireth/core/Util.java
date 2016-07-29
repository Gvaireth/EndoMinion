package org.gvaireth.core;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.joda.time.Duration;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Util {

	private static PeriodFormatter formatter = new PeriodFormatterBuilder().appendDays().appendSuffix("d ")
			.appendHours().appendSuffix("h ").appendMinutes().appendSuffix("m ").appendSeconds().appendSuffix("s ")
			.toFormatter();

	public static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true);
	}

	public static String formatDuration(Long duration) {
		return formatter.print(new Duration(duration).toPeriod());
	}

	static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm dd MM yyyy");

	public static String formatDate(Date d) {
		return DATE_FORMAT.format(d);
	}
}
