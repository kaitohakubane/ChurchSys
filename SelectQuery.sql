
Select *  from Event e, Slot s;

/*Event */
/* e.eventId để xử lí, 
eventName để gắn tiltle, 
numofSlto để tính endTime, 
status để xem, 
subId để tìm subject, 
typeId để xem kiểu là 1 ngày - nhiều ngày, 
startDate để điền vào ô edit, 
privacy để xem public-private
slotId xem đang xem-sửa slot nào, 
roomId xem học phòng nào, 
conductorId xem ai chịu trách nhiệm, 
slotHourId để xem diễn ra ở slot nào   */

Select e.eventId, e.eventName, e.numOfSlot, e.eventStatus, e.subId, e.typeId, e.startDate, e.privacy, s.slotId, s.roomId, s.conductorId, s.slotHourId from Event e, Slot s where e.eventId = s.eventId;


