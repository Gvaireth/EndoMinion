package org.gvaireth.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Sport {

	RUNNING(0, "Running"),

	CYCLING_TRANSPORT(1, "Cycling, transport"),

	CYCLING_SPORT(2, "Cycling, sport"),

	MOUNTAIN_BIKING(3, "Mountain biking"),

	SKATING(4, "Skating"),

	ROLLER_SKIING(5, "Roller skiing"),

	SKIING_CROSS_COUNTRY(6, "Skiing, cross country"),

	SKIING_DOWNHILL(7, "Skiing, downhill"),

	SNOWBOARDING(8, "Snowboarding"),

	KAYAKING(9, "Kayaking"),

	KITE_SURFING(10, "Kite surfing"),

	ROWING(11, "Rowing"),

	SAILING(12, "Sailing"),

	WINDSURFING(13, "Windsurfing"),

	FITNESS_WALKING(14, "Fitness walking"),

	GOLFING(15, "Golfing"),

	HIKING(16, "Hiking"),

	ORIENTEERING(17, "Orienteering"),

	WALKING(18, "Walking"),

	RIDING(19, "Riding"),

	SWIMMING(20, "Swimming"),

	INDOOR_CYCLING(21, "Indoor cycling"),

	OTHER(22, "Other"),

	AEROBICS(23, "Aerobics"),

	BADMINTON(24, "Badminton"),

	BASEBALL(25, "Baseball"),

	BASKETBALL(26, "Basketball"),

	BOXING(27, "Boxing"),

	CLIMBING_STAIRS(28, "Climbing stairs"),

	CRICKET(29, "Cricket"),

	ELLIPTICAL_TRAINING(30, "Elliptical training"),

	DANCING(31, "Dancing"),

	FENCING(32, "Fencing"),

	FOOTBALL_AMERICAN(33, "Football, American"),

	FOOTBALL_RUGBY(34, "Football, rugby"),

	FOOTBALL_SOCCER(35, "Football, soccer"),

	HANDBALL(36, "Handball"),

	HOCKEY(37, "Hockey"), PILATES(38, "Pilates"),

	POLO(39, "Polo"),

	SCUBA_DIVING(40, "Scuba diving"),

	SQUASH(41, "Squash"),

	TABLE_TENNIS(42, "Table tennis"),

	TENNIS(43, "Tennis"),

	VOLLEYBALL_BEACH(44, "Volleyball, beach"),

	VOLLEYBALL_INDOOR(45, "Volleyball, indoor"),

	WEIGHT_TRAINING(46, "Weight training"),

	YOGA(47, "Yoga"),

	MARTIAL_ARTS(48, "Martial arts"),

	GYMNASTICS(49, "Gymnastics"),

	STEP_COUNTER(50, "Step counter"),

	CIRCUIT_TRAINING(87, "Circuit Training"),

	TREADMILL_RUNNING(88, "Treadmill running"),

	SKATEBOARDING(89, "Skateboarding"),

	SURFING(90, "Surfing"),

	SNOWSHOEING(91, "Snowshoeing"),

	WHEELCHAIR(92, "Wheelchair"),

	CLIMBING(93, "Climbing"),

	TREADMILL_WALKING(94, "Treadmill walking"),

	UNKNONWN(999, "Unknown"),

	ALL(1000, "All");

	private int number;
	private String desc;

	private Sport(int number, String desc) {
		this.number = number;
		this.desc = desc;
	}

	public String description() {
		return desc;
	}

	@JsonCreator
	public static Sport fromNumber(int number) {
		for (Sport item : Sport.values()) {
			if (item.number == number) {
				return item;
			}
		}
		return UNKNONWN;
	}

}
