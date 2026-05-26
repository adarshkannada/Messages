package org.fossify.messages.interfaces

import androidx.room.*
import org.fossify.messages.models.Reminder

@Dao
interface RemindersDao {
    @Query("SELECT * FROM reminders ORDER BY due_date ASC")
    fun getAllReminders(): List<Reminder>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(reminder: Reminder): Long

    @Delete
    fun delete(reminder: Reminder)

    @Query("DELETE FROM reminders WHERE id = :id")
    fun deleteReminder(id: Long)

    @Query("SELECT * FROM reminders WHERE sms_id = :smsId")
    fun getReminderBySmsId(smsId: Long): Reminder?
}
