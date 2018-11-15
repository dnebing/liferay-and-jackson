package com.dnebinger.jackson.pojo.animal;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.builder.ToStringStyle;

public class CustomToStringStyle extends ToStringStyle {

	public static final CustomToStringStyle CUSTOM_TO_STRING_STYLE = new CustomToStringStyle();

	/**
	 * <p>Constructor.</p>
	 *
	 * <p>Use the static constant rather than instantiating.</p>
	 */
	public CustomToStringStyle() {
		super();
		this.setContentStart("[");
		this.setFieldSeparator(SystemUtils.LINE_SEPARATOR + "  ");
		this.setFieldSeparatorAtStart(true);
		this.setContentEnd(SystemUtils.LINE_SEPARATOR + "]");
		setUseIdentityHashCode(false);
	}

	/**
	 * <p>Ensure <code>Singleton</code> after serialization.</p>
	 *
	 * @return the singleton
	 */
	private Object readResolve() {
		return CUSTOM_TO_STRING_STYLE;
	}
}
