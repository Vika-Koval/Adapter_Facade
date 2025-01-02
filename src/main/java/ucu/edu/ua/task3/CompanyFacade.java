package ucu.edu.ua.task3;


import java.io.IOException;

public class CompanyFacade {
    private final PDLReader pdlReader;
    private final WebScrapingChatGPTReader webScrapingChatGPTReader;
    private final BrandfetchReader brandfetchReader;

    public CompanyFacade() {
        this.pdlReader = new PDLReader();
        this.webScrapingChatGPTReader = new WebScrapingChatGPTReader();
        this.brandfetchReader = new BrandfetchReader();
    }

    public Company getCompanyInfo(String website) throws IOException {
        Company company = new Company();
        StringBuilder descriptionBuilder = new StringBuilder();

        processSource(company, descriptionBuilder, "PDL", () -> pdlReader.getCompanyInfo(website));
        processSource(company, descriptionBuilder, "GPT", () -> webScrapingChatGPTReader.getCompanyInfo(website));
        processSource(company, descriptionBuilder, "Brandfetch", () -> brandfetchReader.getCompanyInfo(website));

        company.setDescription(descriptionBuilder.toString());
        return company;
    }

    private void processSource(Company company, StringBuilder descriptionBuilder, String sourceName, CompanySupplier supplier) throws IOException {
        Company sourceCompany = supplier.get();

        if (company.getName() == null && sourceCompany.getName() != null) {
            company.setName(sourceCompany.getName());
        }

        if (company.getLogo() == null && sourceCompany.getLogo() != null) {
            company.setLogo(sourceCompany.getLogo());
        }

        if (sourceCompany.getDescription() != null) {
            descriptionBuilder.append("Description from ").append(sourceName).append(": ")
                    .append(sourceCompany.getDescription()).append("; ");
        }
    }

    @FunctionalInterface
    private interface CompanySupplier {
        Company get() throws IOException;
    }
}
