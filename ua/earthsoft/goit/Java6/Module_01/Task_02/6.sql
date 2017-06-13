select
	projects.name as project,
	SUM(projects.cost) as profitCompany,
	AvgDeveloper.salaryAVG as avgSalaryForDevelopers
FROM java6._customerproject_developer
left join _customer_project
	on _customer_project.id = _customerproject_developer.customerProject
left join projects
	on _customer_project.project = projects.id
left join (select 
	_customer_project.customer as customer,
	_customer_project.project as project,
	AVG(developers.salary) as salaryAVG
	from _customerproject_developer
	left join _customer_project
	on _customerproject_developer.customerProject = _customer_project.id
	left join developers
	on developers.id = _customerproject_developer.developer
	group by customer, project) as AvgDeveloper
on AvgDeveloper.project = projects.id and AvgDeveloper.customer = _customer_project.customer
group by project
order by profitCompany
limit 1