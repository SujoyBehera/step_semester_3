package week8.assigment_problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface NotificationChannel {
    String getChannelName();
    String send(String recipientName, String message);

    class Student extends BroadcasterStudent {
        public Student(String name, String department) {
            super(name, department);
        }
    }
}

class EmailChannel implements NotificationChannel {
    @Override
    public String getChannelName() {
        return "Email";
    }

    @Override
    public String send(String recipientName, String message) {
        return "[Email → " + recipientName + "] " + message + ".";
    }
}

class AppChannel implements NotificationChannel {
    @Override
    public String getChannelName() {
        return "App";
    }

    @Override
    public String send(String recipientName, String message) {
        return "[App → " + recipientName + "] " + message + ".";
    }
}

class SmsChannel implements NotificationChannel {
    @Override
    public String getChannelName() {
        return "SMS";
    }

    @Override
    public String send(String recipientName, String message) {
        return "[SMS → " + recipientName + "] " + message + ".";
    }
}

class BroadcasterStudent {
    private final String name;
    private final String department;
    private final List<NotificationChannel> channels = new ArrayList<>();

    public BroadcasterStudent(String name, String department) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("department cannot be blank");
        }
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<NotificationChannel> getChannels() {
        return Collections.unmodifiableList(channels);
    }

    public void addPreferredChannel(NotificationChannel channel) {
        if (channel != null && !channels.contains(channel)) {
            channels.add(channel);
        }
    }
}

class Notice {
    private final String title;
    private final List<String> targetDepartments;

    public Notice(String title, List<String> targetDepartments) {
        this.title = title;
        this.targetDepartments = targetDepartments != null ? new ArrayList<>(targetDepartments) : Collections.emptyList();
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTargetDepartments() {
        return Collections.unmodifiableList(targetDepartments);
    }

    public String validate() {
        if (title == null || title.trim().isEmpty()) {
            return "Cannot post notice: Title is required.";
        }
        if (targetDepartments == null || targetDepartments.isEmpty()) {
            return "Cannot post notice: At least one target department is required.";
        }
        return null;
    }
}

class NoticeBoard {
    private final List<BroadcasterStudent> registeredStudents = new ArrayList<>();

    public void registerStudent(BroadcasterStudent student) {
        if (student != null) {
            registeredStudents.add(student);
        }
    }

    public List<String> postNotice(Notice notice) {
        List<String> output = new ArrayList<>();
        if (notice == null) {
            output.add("Cannot post notice: Notice is null.");
            return output;
        }

        String validationError = notice.validate();
        if (validationError != null) {
            output.add(validationError);
            return output;
        }

        output.add("Notice '" + notice.getTitle() + "' posted to " + String.join(", ", notice.getTargetDepartments()) + ".");
        for (BroadcasterStudent student : registeredStudents) {
            if (notice.getTargetDepartments().contains(student.getDepartment())) {
                for (NotificationChannel channel : student.getChannels()) {
                    output.add(channel.send(student.getName(), notice.getTitle()));
                }
            }
        }
        return output;
    }
}
