create database ipl;
use ipl;
create table umpire(umpire_id int primary key not null,
umpire_name char(25));

create table team(team_id int primary key not null,
team_name char(35));

create table venue(venue_id int primary key not null,
city char(20),venue_name varchar(60));


create table toss(toss_id int primary key not null,
toss_decision char(10));


create table match_details
(
match_id int primary key not null,
date date,venue_id int,
season int,
team1_id int,
team2_id int,
toss_id int,
tosswinner_id int,
umpire1_id int,
umpire2_id int,
foreign key(venue_id) references venue(venue_id),
foreign key(team1_id) references team(team_id),
foreign key(team2_id) references team(team_id),
foreign key(toss_id) references toss(toss_id),
foreign key(tosswinner_id) references team(team_id),
foreign key(umpire1_id) references umpire(umpire_id),
foreign key(umpire2_id) references umpire(umpire_id));


create table outcome(match_id int,
player_of_match char(20),
win_by_runs int,
win_by_wickets int,
winner_team_id int,
foreign key(match_id) references match_details(match_id),
foreign key(winner_team_id) references team(team_id));

create table look_up(toss_decision char(10));
