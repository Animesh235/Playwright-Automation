import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

public class PlaywrightAutomationScript {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            // Navigate to the target URL
            page.navigate("https://softwaretesterpoint.blogspot.com/");

            // Perform interactions on the page
            performInteractions(page);
        }
    }

    private static void performInteractions(Page page) {
        // Clicking on icons
        page.locator("i").click();
        page.locator("i").click();

        // Performing search
        page.getByLabel("Toggle search").locator("svg").click();
        page.getByPlaceholder("Enter your search").click();
        page.getByPlaceholder("Enter your search").fill("agile");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();

        // Navigating through search results and sections
        page.getByText("What Is Agile Testing ?").click();
        page.getByText("Table Of Contents:").click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Agile Testing Life Cycle:")).click();
        page.getByLabel("Back to Top").click();

        // Navigating through different menu items
        navigateMenuItems(page);
    }

    private static void navigateMenuItems(Page page) {
        // Navigate to Home and then Load Testing
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Home")).click();
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Load Testing")).click();
        page.locator("#toc-toggler span").nth(1).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Process of Load Testing:")).click();
        page.getByLabel("Back to Top").click();

        // Navigate to Lean Model and its benefits
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Lean Model")).click();
        page.getByText("Table Of Contents:").click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Benefits of Lean:")).click();
        page.getByLabel("Back to Top").click();

        // Navigate to Spiral Model and Disclaimer
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Spiral Model")).click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Disclaimer")).click();
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Home")).click();
    }
}
