
alter table Subject add foreign key (categoryId) references Category(categoryId);

alter table RoomCapable add foreign key (subId) references Subject(subId);

alter table RoomCapable add foreign key (roomId) references Room(roomId);

alter table Event add foreign key (subId) references Subject(subId);

alter table Event add foreign key (churchId) references church(churchId);

alter table Event add foreign key (typeId) references type (typeId);

alter table Registration add foreign key (eventId) references Event(eventId);

alter table Registration add foreign key (subId) references Subject(subId);

alter table Registration add foreign key (userId) references User(userId);

alter table Registration add foreign key (churchId) references Church(churchId);

alter table Question add foreign key (subId) references Subject (subId);

alter table Question add foreign key (userId) references User (userId);

alter table Question add foreign key (conductorId) references User(userId);

alter table Post add foreign key (conductorId) references User(userId);

alter table Contribution add foreign key (userId) references User (userId);

alter table Contribution add foreign key (postId) references Post(postId);

alter table Slot add foreign key (eventId) references Event(eventId);

alter table Slot add foreign key (roomId) references Room (roomId);

alter table Slot add foreign key (slotHourId) references SlotHour(slotHourId);

alter table Slot add foreign key (conductorId) references User(userId);

alter table Ability add foreign key (conductorId) references User(userId);

alter table Ability add foreign key (subId) references Subject(subId);

alter table Room add foreign key (churchId) references Church(churchId);

alter table Interaction add foreign key (churchId) references Church(churchId);

alter table Interaction add foreign key (userId) references User(userId);
