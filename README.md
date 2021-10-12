# Donation-Calculator
The program tells the user a fact about poverty and how any amount of donation can help. It then informs the user of different charities they can donate to.

# Key Features
New session tracker. The program creates variables to find the current date and time in UTC. It then tries to create a file to save the session data. If the file already exists, the program will append the new session below the previous.

JOptionPanes. These panes are the main communication between the user and the program. This includes taking inputs and converting them into double values. To liven up the JOptionPanes, images were added to some JOptionPanes. They are also used later on to confirm actions and present the user with multiple selectable options.

Upseller. The program takes the calculated leftover amount and tries to upsell the user into donating more. The user is told about how additional money could help along with a suitable image. The program will keep trying to upsell until the user has chosen to donate an amount equal to or over $200.

Multiple charity options. The program offers the user six charities to learn more about. The mission of the charities and the score by Charity Navigator are displayed to help the user make an informed decision on where to donate their money to. The user can look through all their options before finalizing on a charity.

Logging previous donations. The program writes to the save file and records the amount donated and where to. This allows the user to in the future, look back and see how much and where they previously donated money.
